package com.example.bottomnavs.ui.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavs.databinding.FragmentNotificationsBinding;

import java.text.BreakIterator;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

         TextView textView = binding.textNotifications;
        final Button checkStatus = binding.buttonCheck;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        IntentFilter IntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        checkStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().registerReceiver(broadcastereceiver, new IntentFilter());
            }
        });
        return root;
    }

    private BroadcastReceiver broadcastereceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int deviceHealth;
            deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);

            BreakIterator textview;
            textview = null;
            String currentBatteryHealth = null;
            if(deviceHealth == BatteryManager.BATTERY_HEALTH_COLD){

                textview.setText(currentBatteryHealth+"Cold");
            }

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_DEAD){
                textview.setText(currentBatteryHealth+" = Dead");
            }
            if(deviceHealth == BatteryManager.BATTERY_HEALTH_GOOD){
                textview.setText(currentBatteryHealth+" = Good");
            }
            if(deviceHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT{
               textview.setText(currentBatteryHealth+" = OverHeat***");
            }
        }
    };
}