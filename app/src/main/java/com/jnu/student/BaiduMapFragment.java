package com.jnu.student;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jnu.student.data.DataDownload;
import com.jnu.student.data.ShopLocation;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

import java.util.ArrayList;

public class BaiduMapFragment extends Fragment {
    private com.tencent.tencentmap.mapsdk.maps.MapView mapView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_baidu_map, container, false);
        mapView = rootView.findViewById(R.id.mapView);


        TencentMap tencentMap = mapView.getMap();

        LatLng point1 = new LatLng(22.255453, 113.54145);
        tencentMap.moveCamera(CameraUpdateFactory.newLatLng(point1));
        new Thread(new Runnable() {
            @Override
            public void run() {
                String responseData=new DataDownload().download("https://file.nidama.net/class/mobile_develop/data/bookstore.json");
                ArrayList<ShopLocation> shopLocations= new DataDownload().parseJsonObjects(responseData);

                requireActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TencentMap tencentMap = mapView.getMap();
                        for (ShopLocation shopLocation : shopLocations) {
                            LatLng point1 = new LatLng(shopLocation.getLatitude(), shopLocation.getLongitude());
                            MarkerOptions markerOptions = new MarkerOptions(point1)
                                    .title(shopLocation.getName());
                            Marker marker = tencentMap.addMarker(markerOptions);


                        }
                    }
                });
            }
        }).start();

        // 创建一个Marker对象
        MarkerOptions markerOptions = new MarkerOptions(point1)
                .title("标记标题");
        Marker marker = tencentMap.addMarker(markerOptions);
/*
        CameraUpdate cameraSigma =
                CameraUpdateFactory.newCameraPosition(new CameraPosition(
                        new LatLng(22.249942,113.534341), //中心点坐标，地图目标经纬度
                        17,  //目标缩放级别
                        0f, //目标倾斜角[0.0 ~ 45.0] (垂直地图时为0)
                        0f)); //目标旋转角 0~360° (正北方为0)
        tencentMap.moveCamera(cameraSigma); //移动地图

        LatLng position = new LatLng(22.249942,113.534341);
        MarkerOptions options = new MarkerOptions(position);
        options.infoWindowEnable(false);//默认为true
        options.title("暨南大学珠海校区")//标注的InfoWindow的标题
                .snippet("地址: 珠海市香洲区前山路206号");//标注的InfoWindow的内容
        Marker mMarker;
        mMarker = tencentMap.addMarker(options);
        mMarker.setInfoWindowEnable(true);
        // 添加标记到地图上
        // Marker marker = tencentMap.addMarker(markerOptions);
*/
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
