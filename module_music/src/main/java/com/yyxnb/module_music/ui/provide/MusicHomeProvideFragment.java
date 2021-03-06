package com.yyxnb.module_music.ui.provide;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yyxnb.common_base.core.BaseFragment;
import com.yyxnb.lib_arch.annotations.BindRes;
import com.yyxnb.module_music.R;
import com.yyxnb.module_music.databinding.FragmentMusicHomeProvideBinding;

import static com.yyxnb.common_res.arouter.ARouterConstant.MUSIC_HOME_PROVIDE_FRAGMENT;

/**
 * ================================================
 * 作    者：yyx
 * 日    期：2020/11/30
 * 描    述：对外提供音乐首页
 * ================================================
 */
@BindRes(subPage = true)
@Route(path = MUSIC_HOME_PROVIDE_FRAGMENT)
public class MusicHomeProvideFragment extends BaseFragment {


    private FragmentMusicHomeProvideBinding binding;

    @Override
    public int initLayoutResId() {
        return R.layout.fragment_music_home_provide;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        binding = getBinding();

        binding.iRv.vStatus.showEmptyView();
    }
}