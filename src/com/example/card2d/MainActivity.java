package com.example.card2d;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
private ImageView imageA;
private ImageView imageB;
private ScaleAnimation sat0=new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
private ScaleAnimation sat1=new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		findViewById(R.id.root).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (imageA.getVisibility()==View.VISIBLE) {
					imageA.startAnimation(sat0);
				} else {
         imageB.startAnimation(sat0);
				}
				
			}
		});
	}
public void showImageA(){
	
	imageA.setVisibility(View.VISIBLE);
	imageB.setVisibility(View.INVISIBLE);
}
public void showImageB(){
	imageB.setVisibility(View.VISIBLE);
	imageA.setVisibility(View.INVISIBLE);
}
private void initView(){
	
	imageA=(ImageView) findViewById(R.id.ivA);
	imageB=(ImageView) findViewById(R.id.ivB);
	showImageA();
	sat0.setDuration(500);
	sat1.setDuration(500);
	sat0.setAnimationListener(new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			if (imageA.getVisibility()==View.VISIBLE) {
				imageA.setAnimation(null);
				showImageB();
				imageB.setAnimation(sat1);
			}else {
				imageA.setAnimation(null);
				showImageB();
				imageB.setAnimation(sat0);
			}
		}
	});
}




}
