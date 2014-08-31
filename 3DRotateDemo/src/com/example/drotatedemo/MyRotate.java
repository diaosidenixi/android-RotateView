package com.example.drotatedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyRotate extends Activity{
	
	private ImageView img1 , img2 ; 
	
	private RelativeLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myrotate);
		initDate();
		initRotate();
	}

	private void initDate() {
		img1 = (ImageView)findViewById(R.id.img_1);
		img2 = (ImageView)findViewById(R.id.img_2);
		layout = (RelativeLayout)findViewById(R.id.r_layout);
	}
	
	private void initRotate() {
		img1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int width = img1.getWidth();
				int height = img1.getHeight();
				Log.i("DemoLog", "width" + width + "Height" + height);
				Rotate3dAnimation animation = new Rotate3dAnimation(0,90,width/2f,height/2f,310.0f,true);
				animation.setInterpolator(new AccelerateInterpolator());
				animation.setDuration(500);
				animation.setFillAfter(true);
				animation.setAnimationListener(new RotateAnimtionListener(img1,img2));
				layout.startAnimation(animation);
			}
		});
		
		img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int width = img2.getWidth();
				int height = img2.getHeight();
				Log.i("DemoLog", "width" + width + "Height" + height);
				Rotate3dAnimation animation = new Rotate3dAnimation(0,90,width/2f,height/2f,310.0f,true);
				animation.setInterpolator(new AccelerateInterpolator());
				animation.setDuration(500);
				animation.setFillAfter(true);
				animation.setAnimationListener(new RotateAnimtionListener(img2,img1));
				layout.startAnimation(animation);
			}
		});
	}
	
	class RotateAnimtionListener implements Animation.AnimationListener{

		private View view1 , view2;
		
		
		
		public RotateAnimtionListener(View view1, View view2) {
			super();
			this.view1 = view1;
			this.view2 = view2;
		}

		@Override
		public void onAnimationStart(Animation animation) {
			
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			view1.setVisibility(View.GONE);
			
			view2.setVisibility(View.VISIBLE);
			int width = view2.getWidth();
			int height = view2.getHeight();
			Rotate3dAnimation animationback = 
					new Rotate3dAnimation(270,360,width/2f,height/2f,310.0f,true);
			animationback.setInterpolator(new AccelerateInterpolator());
			animationback.setDuration(500);
			animationback.setFillAfter(true);
			layout.startAnimation(animationback);
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			
		}
		
	}
	
}
