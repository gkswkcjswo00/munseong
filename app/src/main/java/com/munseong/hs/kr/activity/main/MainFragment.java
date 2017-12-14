package com.munseong.hs.kr.activity.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.munseong.hs.kr.R;
import com.munseong.hs.kr.activity.school;
import com.munseong.hs.kr.activity.bap.BapActivity;
import com.munseong.hs.kr.activity.notice.NoticeActivity;
import com.munseong.hs.kr.activity.timetable.TimeTableActivity;
import com.munseong.hs.kr.activity.schedule.ScheduleActivity;
import com.munseong.hs.kr.activity.exam.ExamTimeActivity;
import com.munseong.hs.kr.tool.BapTool;
import com.munseong.hs.kr.tool.Preference;
import com.munseong.hs.kr.tool.RecyclerItemClickListener;
import com.munseong.hs.kr.tool.TimeTableTool;

/**
 * Created by whdghks913 on 2015-11-30.
 */
public class MainFragment extends Fragment {

    public static Fragment getInstance(int code) {
        MainFragment mFragment = new MainFragment();

        Bundle args = new Bundle();
        args.putInt("code", code);
        mFragment.setArguments(args);

        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recyclerview, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        final MainAdapter mAdapter = new MainAdapter(getActivity());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View mView, int position) {
                boolean isSimple = mAdapter.getItemData(position).isSimple;

                if (isSimple) {
                    switch (position) {

                        case 0:
                            startActivity(new Intent(getActivity(), school.class));
                            break;
                        case 1:
                            startActivity(new Intent(getActivity(), BapActivity.class));
                            break;
                        case 2:
                            startActivity(new Intent(getActivity(), TimeTableActivity.class));
                            break;
                    }
                } else {
                    switch (position) {
                        case 0:
                            startActivity(new Intent(getActivity(), NoticeActivity.class));
                            break;
                        case 1:
                            startActivity(new Intent(getActivity(), ScheduleActivity.class));
                            break;
                        case 2:

                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                                    ("https://www.dbdbschool.kr/member/login/sn/685")));

                            break;
                        case 3:

                                                        startActivity(new Intent(getActivity(), ExamTimeActivity.class));
                            break;
                    }
                }
            }
        }));

        Bundle args = getArguments();
        int code = args.getInt("code");
        Preference mPref = new Preference(getActivity());

        if (code == 1) {
            // SimpleView

            mAdapter.addItem(R.mipmap.ic_launcher,
                    getString(R.string.title_activity_school),
                    getString(R.string.message_activity_school),
                    getString(R.string.title_activity_school_notice),
                    getString(R.string.message_activity_school_notice));


            if (mPref.getBoolean("simpleShowBap", true)) {
                BapTool.todayBapData mBapData = BapTool.getTodayBap(getActivity());
                mAdapter.addItem(R.drawable.rice,
                        getString(R.string.title_activity_bap),
                        getString(R.string.message_activity_bap),
                        mBapData.title,
                        mBapData.info);
            } else {
                mAdapter.addItem(R.drawable.rice,
                        getString(R.string.title_activity_bap),
                        getString(R.string.message_activity_bap), true);
            }

            if (mPref.getBoolean("simpleShowTimeTable", true)) {
                TimeTableTool.todayTimeTableData mTimeTableData = TimeTableTool.getTodayTimeTable(getActivity());
                mAdapter.addItem(R.drawable.timetable,
                        getString(R.string.title_activity_time_table),
                        getString(R.string.message_activity_time_table),
                        mTimeTableData.title,
                        mTimeTableData.info);
            } else {
                mAdapter.addItem(R.drawable.timetable,
                        getString(R.string.title_activity_time_table),
                        getString(R.string.message_activity_time_table), true);
            }
        } else {
            // DetailedView
            mAdapter.addItem(R.drawable.notice,
                    getString(R.string.title_activity_notice),
                    getString(R.string.message_activity_notice));
            mAdapter.addItem(R.drawable.calendar,
                    getString(R.string.title_activity_schedule),
                    getString(R.string.message_activity_schedule));
            mAdapter.addItem(R.mipmap.after,
                    getString(R.string.title_activity_aft),
                    getString(R.string.message_activity_aft));
            mAdapter.addItem(R.mipmap.ic_launcher,
                    getString(R.string.title_activity_exam_range),
                    getString(R.string.message_activity_exam_range));
        }

        return recyclerView;
    }
}
