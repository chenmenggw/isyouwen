package com.bm.wanma.ui.activity;

import com.bm.wanma.R;
import com.bm.wanma.entity.MyNewsSystemBean;
import com.bm.wanma.utils.Tools;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * @author cm
 * 系统消息详情界面
 */
public class MyNewsSystemDetailActivity extends Activity implements OnClickListener{
	
	private ImageButton ib_back;
	private TextView tv_title,tv_time,tv_content;
	private MyNewsSystemBean bean;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mynews_system_detail);
		bean = (MyNewsSystemBean) getIntent().getSerializableExtra("itemBean");
		ib_back = (ImageButton) findViewById(R.id.mynews_system_detail_back);
		ib_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.mynews_system_detail_title);
		tv_time = (TextView) findViewById(R.id.mynews_system_detail_time);
		tv_content = (TextView) findViewById(R.id.mynews_system_detail_content);
		if(bean!= null){
			tv_title.setText(""+bean.getTitle());
			String tempTime = bean.getEdittime();
			tempTime = Tools.parseDate(tempTime, "yyyy-MM-dd HH:mm:ss", "yy/MM/dd HH:mm");
			tv_time.setText(tempTime);
			tv_content.setText(""+bean.getContent());
			
		}
		
	}
	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mynews_system_detail_back:
			finish();
			break;

		default:
			break;
		}
		
	}
	

}
