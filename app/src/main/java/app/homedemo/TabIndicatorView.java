package app.homedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TabIndicatorView extends RelativeLayout {
	private ImageView ivTabIcon;
	private TextView tvTabHint;
	private TextView tvTabUnRead;

	private int normalIconId;
	private int focusIconId;

	public TabIndicatorView(Context context) {
		this(context, null);
	}

	public TabIndicatorView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 将布局文件和 代码进行绑定
		View.inflate(context, R.layout.tab_item_view, this);

		ivTabIcon = (ImageView) findViewById(R.id.imageview);
		tvTabHint = (TextView) findViewById(R.id.textview);
		tvTabUnRead = (TextView) findViewById(R.id.tv_red);//未读消息
		
		setTabUnreadCount(0);
	}

	// 设置tab的title
	public void setTabTitle(String title) {
		tvTabHint.setText(title);
	}

	public void setTabTitle(int titleId) {
		tvTabHint.setText(titleId);
	}

	// 初始化图标
	public void setTabIcon(int normalIconId, int focusIconId) {
		this.normalIconId = normalIconId;
		this.focusIconId = focusIconId;

		ivTabIcon.setImageResource(normalIconId);
	}

	// 设置未读数
	public void setTabUnreadCount(int unreadCount) {
		if (unreadCount <= 0) {
			tvTabUnRead.setVisibility(View.GONE);
		} else {
			if (unreadCount <= 99) {
				tvTabUnRead.setText(unreadCount + "");
			} else {
				tvTabUnRead.setText("99+");
			}

			tvTabUnRead.setVisibility(View.VISIBLE);
		}
	}

	// 设置选中
	public void setTabSelected(boolean selected) {
		if (selected) {
			ivTabIcon.setImageResource(focusIconId);
		} else {
			ivTabIcon.setImageResource(normalIconId);
		}
	}
}