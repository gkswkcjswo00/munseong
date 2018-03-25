package com.munseong.hs.kr.activity.schedule;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.munseong.hs.kr.R;
import com.munseong.hs.kr.tool.RecyclerItemClickListener;

/**
 * Created by whdghks913 on 2015-12-10.
 */
public class ScheduleFragment extends Fragment {

    public static Fragment getInstance(int month) {
        ScheduleFragment mFragment = new ScheduleFragment();

        Bundle args = new Bundle();
        args.putInt("month", month);
        mFragment.setArguments(args);

        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recyclerview, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        final ScheduleAdapter mAdapter = new ScheduleAdapter();
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View mView, int position) {
                try {
                    String date = mAdapter.getItemData(position).date;
                    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy.MM.dd (E)", Locale.KOREA);

                    Calendar mCalendar = Calendar.getInstance();
                    long nowTime = mCalendar.getTimeInMillis();

                    mCalendar.setTime(mFormat.parse(date));
                    long touchTime = mCalendar.getTimeInMillis();

                    long diff = (touchTime - nowTime);

                    boolean isPast = false;
                    if (diff < 0) {
                        diff = -diff;
                        isPast = true;
                    }

                    int diffDays = (int) (diff /= 24 * 60 * 60 * 1000);
                    String mText = "";

                    if (diffDays == 0)
                        mText += "오늘 일정입니다.";
                    else if (isPast)
                        mText = "선택하신 날짜는 " + diffDays + "일전 날짜입니다";
                    else
                        mText = "선택하신 날짜까지 " + diffDays + "일 남았습니다";

                    Snackbar.make(mView, mText, Snackbar.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }));

        Bundle args = getArguments();
        int month = args.getInt("month");

        switch (month) {
            case 3:
                mAdapter.addItem("3.1절", "2018.03.01 (목)", true);
                mAdapter.addItem("입학식 및 시업식", "2018.03.02 (금)");
                mAdapter.addItem("전국 연합 학력 평가 (3학년)", "2018.03.08 (목)");
                break;
            case 4:
                mAdapter.addItem("수학여행 (1학년)", "2018.04.10 (화)");
                mAdapter.addItem("전국 연합 학력 평가 (3학년)", "2018.04.11 (수)");
                mAdapter.addItem("수학여행&수련회 (1학년,2학년)", "2018.04.11 (수)");
                mAdapter.addItem("수학여행&수련회 (1학년,2학년)", "2018.04.12 (목)");
                mAdapter.addItem("수학여행&수련회 (1학년,2학년)", "2018.04.13 (금)");
                mAdapter.addItem("체험학습 (3학년)", "2018.04.13 (금)");
                mAdapter.addItem("영어 듣기 평가", "2018.04.17 (화)");
                mAdapter.addItem("영어 듣기 평가", "2018.04.18 (수)");
                mAdapter.addItem("영어 듣기 평가", "2018.04.19 (목)");
                mAdapter.addItem("체육대회", "2018.04.20 (금)");

                break;
            case 5:
                mAdapter.addItem("개교기념일", "2018.05.01 (화)", true);
                mAdapter.addItem("중간고사 (1,2,3학년)", "2018.05.02 (수)");
                mAdapter.addItem("중간고사 (1,2,3학년)", "2018.05.03 (목)");
                mAdapter.addItem("중간고사 (1,2,3학년)", "2018.05.04 (금)");
                mAdapter.addItem("어린이날", "2018.05.05 (토)", true);
                mAdapter.addItem("대체휴일", "2018.05.07 (월)", true);
                mAdapter.addItem("재량휴업일", "2018.05.21 (월)", true);
                mAdapter.addItem("석가탄신일", "2018.05.22 (화)", true);


                break;
            case 6:
                mAdapter.addItem("현충일", "2018.06.06 (수)", true);
                mAdapter.addItem("전국 연합 학력 평가 (1,2학년)", "2018.06.07 (목)");
                mAdapter.addItem("대 수능 모의 평가 (3학년)", "2018.06.07 (목)");
                mAdapter.addItem("지방선거", "2018.06.13 (수)", true);
                break;
            case 7:
                mAdapter.addItem("기말고사 (1,2,3학년)", "2018.07.04 (수)");
                mAdapter.addItem("기말고사 (1,2,3학년)", "2018.07.05 (목)");
                mAdapter.addItem("기말고사 (1,2,3학년)", "2018.07.06 (금)");
                mAdapter.addItem("꿈끼 탐색주간", "2018.07.09 (월)");
                mAdapter.addItem("꿈끼 탐색주간", "2018.07.10 (화)");
                mAdapter.addItem("꿈끼 탐색주간", "2018.07.11 (수)");
                mAdapter.addItem("꿈끼 탐색주간", "2018.07.12 (목)");
                mAdapter.addItem("꿈끼 탐색주간", "2018.07.13 (금)");
                mAdapter.addItem("전국 연합 학력 평가 (3학년)", "2018.07.11 (수)");
                mAdapter.addItem("학생회장 선거", "2018.07.20 (금)");
                mAdapter.addItem("여름방학식", "2018.07.20 (금)", true);
                mAdapter.addItem("개학식 (3학년)", "2018.07.30 (월)");
                break;
            case 8:
                mAdapter.addItem("개학식 (1,2학년)", "2018.08.06 (월)");
                mAdapter.addItem("중간고사 (3학년)", "2018.08.08 (수)");
                mAdapter.addItem("중간고사 (3학년)", "2018.08.09 (목)");
                mAdapter.addItem("중간고사 (3학년)", "2018.08.10 (금)");
                mAdapter.addItem("광복절", "2018.08.15 (수)", true);
                break;
            case 9:
                mAdapter.addItem("전국 연합 학력 평가 (1,2학년)", "2018.09.05 (수)");
                mAdapter.addItem("대 수능 모의 평가 (3학년)", "2018.09.05 (수)");
                mAdapter.addItem("영어 듣기 평가", "2018.09.18 (화)");
                mAdapter.addItem("영어 듣기 평가", "2018.09.19 (수)");
                mAdapter.addItem("영어 듣기 평가", "2018.09.20 (목)");
                mAdapter.addItem("추석", "2018.09.24 (월)", true);
                mAdapter.addItem("추석 연휴", "2018.09.25 (화)", true);
                mAdapter.addItem("대체 휴일", "2018.09.26 (수)", true);
                break;

            case 10:
                mAdapter.addItem("중간고사 (1,2학년), 기말고사 (3학년)", "2018.10.02 (화)");
                mAdapter.addItem("개천절", "2018.10.03 (수)", true);
                mAdapter.addItem("중간고사 (1,2학년), 기말고사 (3학년)", "2018.10.04 (목)");
                mAdapter.addItem("중간고사 (1,2학년), 기말고사 (3학년)", "2018.10.05 (금)");
                mAdapter.addItem("한글날", "2018.10.09 (화)", true);
                mAdapter.addItem("전국 연합 학력 평가 (3학년)", "2018.10.16 (화)");
                break;
            case 11:
                mAdapter.addItem("대학 수학 능력 시험", "2018.11.23 (목)", true);
                mAdapter.addItem("전국 연합 학력 평가 (1,2학년)", "2018.11.29 (수)");

                break;
            case 12:
                mAdapter.addItem("문성 축제", "2018.12.01 (금)");
                mAdapter.addItem("기말고사 (1,2학년)", "2018.12.18 (월)");
                mAdapter.addItem("기말고사 (1,2학년)", "2018.12.19 (화)");
                mAdapter.addItem("기말고사 (1,2학년)", "2018.12.20 (수)");
                mAdapter.addItem("꿈끼 탐색주간 (3학년)", "2018.12.21 (목)");
                mAdapter.addItem("꿈끼 탐색주간 (3학년)", "2018.12.22 (금)");
                mAdapter.addItem("성탄절", "2018.12.25 (월)", true);
                mAdapter.addItem("꿈끼 탐색주간 (3학년)", "2018.12.26 (화)");
                mAdapter.addItem("꿈끼 탐색주간 (3학년)", "2018.12.27 (수)");
                mAdapter.addItem("꿈끼 탐색주간 (3학년)", "2018.12.28 (목)");

                break;
            case 1:
                mAdapter.addItem("신정", "2019.01.01 (월)", true);
                mAdapter.addItem("방학식", "2019.01.03 (수)");
                break;
            case 2:
                mAdapter.addItem("개학식 (1,2학년)", "2019.02.05 (월)");
                mAdapter.addItem("개학식 (3학년)", "2019.02.08 (목)");
                mAdapter.addItem("졸업식/종업식", "2019.02.09 (금)", true);
                break;
        }

        return recyclerView;
    }
}
