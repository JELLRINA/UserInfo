package com.example.userinfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvEmail, toastText;
    Button btn1;
    EditText dlgEdtName, dlgEdtEmail;

    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        //info 변수 대입
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.activity_dialog1, null); //다이얼로그뷰에 인플레이트 하여 대입
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends); //대화상자 아이콘 설정
                dlg.setView(dialogView); //인플레이트 한 뷰를 대화상자에 적용

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2); //인플레이트한 다이얼로그뷰에 다이얼로그.xml 변수 대입후 메소드 사용

                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText().toString()); //대화상자를 입력한 이름과 이메일을 메인의 텍스트뷰에 적용
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this); //빈 토스트 생성
                        toastView = (View) View.inflate(MainActivity.this,R.layout.activity_toast1, null); //토스트뷰 파일을 인플레이트하여 뷰에 대입
                        toastText = (TextView) toastView.findViewById(R.id.toastText); //토스트뷰를 토스트텍스트와와대입 후 보여지기
                        toastText.setText("취소했습니다");
                        toast.setView(toastView); //인플레이트한 뷰를 토스트로 사용
                        toast.show();
                    }
                }); //확인 취소는 뒤바껴도 상관x
                dlg.show();
            }
        });
    }
}