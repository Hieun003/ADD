package com.example.thuchanhbuoi4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.Manifest;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE= 1;
    Button Search,Call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Search = findViewById(R.id.Search);
        Call = findViewById(R.id.Call);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(mh);
            }
        });
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+84)999333777"));
                startActivity(mh);
            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUEST_CODE){
//             Kiểm tra nếu đã được cấp
            if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                //Quyền đã được cấp, thực hiện cuộc gọi
            }
            else {
                //Quyền bị từ chối
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE))
                // Người dùng đã chọn "Don't ask again"
                // Hiển thị thông báo hoặc chuyển họ đến cài đặt ứng dụng
                showPermissionDeniedDialog();
                else{
                    // Quyền bị từ chối nhưng không phải là "Don't ask again"
                    // Xử lý theo cách bình thường
                }
            }
        }
    }
    private void showPermissionDeniedDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Quyền bị từ chối")
                .setMessage("Bạn cần cấp quyền gọi điện trong cài đặt để tiếp tục sử dụng tính năng này.")
                .setPositiveButton("Đi tới Cài đặt", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Mở cài đặt ứng dụng để người dùng cấp quyền thủ công
                        Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}