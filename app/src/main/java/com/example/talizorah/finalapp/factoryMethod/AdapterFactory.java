package com.example.talizorah.finalapp.factoryMethod;

import android.app.Activity;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.talizorah.finalapp.CourseItems.CourseItem;
import com.example.talizorah.finalapp.CustomViews.CustomListView.CashMachineListView;
import com.example.talizorah.finalapp.CustomViews.CustomListView.CourseListView;
import com.example.talizorah.finalapp.CustomViews.CustomListView.DetailListView;
import com.example.talizorah.finalapp.CustomViews.CustomListView.SimpleListView;
import com.example.talizorah.finalapp.cashMachine.CashMachineItem;
import com.example.talizorah.finalapp.enums.ListViewAdapters;
import com.example.talizorah.finalapp.notes.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by talizorah on 16.8.4.
 */
public class AdapterFactory{
    private AdapterFactory(){
    }
    public static AdapterFactory createAdapterFactory(){
        return new AdapterFactory();
    }
    public BaseAdapter getAdapter(ListViewAdapters adapterType, Activity context, List<?> items){
        try {
            switch (adapterType) {
                case SimpleListView:
                    return new SimpleListView(context, (List<Note>) items);
                case DetailListView:
                    return new DetailListView(context, (List<Note>) items);
                case CourseListView:
                    return new CourseListView(context, (List<CourseItem>) items);
                case CashMachineListView:
                    return new CashMachineListView(context, (List<CashMachineItem>) items);
                default:
                    return null;
            }
        }
        catch (Exception ex){
            Log.v("FACTORY", "Casting error");
        }
        return null;
    }
}
