package com.khomeapps.chatwheel.chat

import com.khomeapps.chatwheel.R
import com.khomeapps.chatwheel.base.BaseFragment
import com.khomeapps.chatwheel.databinding.FragmentChatBinding

/**
 * Created by kubilaay on 2019-05-18.
 */
class ChatFragment : BaseFragment<ChatViewModel, FragmentChatBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_chat

    override fun getFragmentViewModel(): ChatViewModel = ChatViewModel()

}