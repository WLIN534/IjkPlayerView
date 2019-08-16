package  com.zl.playerdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dl7.player.media.IjkPlayerView;
import com.dl7.player.media.IjkVideoView;

/**
 * 项目名称：IjkPlayerView
 * 类描述：
 * 创建人：zhanglin
 * 创建时间：2018/11/28 11:04
 * 修改人：Administrator
 * 修改时间：2018/11/28 11:04
 * 修改备注：
 */
public class VideoActivity extends AppCompatActivity {
    EditText etPath;
    Button start, pause, replay, stop;
    IjkVideoView videoView;
    IjkPlayerView playerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        etPath = (EditText) findViewById(R.id.et_path);
        start = (Button) findViewById(R.id.start);
        pause = (Button) findViewById(R.id.pause);
        replay = (Button) findViewById(R.id.replay);
        stop = (Button) findViewById(R.id.stop);
        videoView = (IjkVideoView) findViewById(R.id.video_view);
        playerView = (IjkPlayerView) findViewById(R.id.player_view);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoPath = etPath.getText().toString();
                videoView.setVideoPath(videoPath);
                videoView.start();
//                playerView.setVideoPath(videoPath);
//                playerView.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
//                playerView.pause();
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                videoView.reload();
                videoView.resume();
//                playerView.reload();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
//                playerView.stop();
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            Toast.makeText(this, "申请权限失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }
}
