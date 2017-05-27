package bookreader.asuper.bookread.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bookreader.asuper.bookread.R;
import bookreader.asuper.bookread.ui.fragment.CommunityFragment;
import bookreader.asuper.bookread.ui.fragment.FindFragment;
import bookreader.asuper.bookread.ui.fragment.RecommendFragment;
import bookreader.asuper.bookread.view.RVPIndicator;
import butterknife.Bind;

public class MainActivity extends BaseActivity {
    private List<Fragment> mTabsContacts;
    private FragmentPagerAdapter mFAdapter;
    private List<String> mTitles;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @Bind(R.id.indicator)
    RVPIndicator mRVPIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
    }

    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public void initView() {
        mViewPager.setAdapter(mFAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mRVPIndicator.setTabItemTitles(mTitles);
        mRVPIndicator.setViewPager(mViewPager, 0);
    }

    public void initData() {
        mTabsContacts = new ArrayList<>();
        mTitles = Arrays.asList(getResources().getStringArray(R.array.home_tabs));
        mTabsContacts.add(new RecommendFragment());
        mTabsContacts.add(new CommunityFragment());
        mTabsContacts.add(new FindFragment());
        mFAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabsContacts.get(position);
            }

            @Override
            public int getCount() {
                return mTabsContacts.size();
            }
        };

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
