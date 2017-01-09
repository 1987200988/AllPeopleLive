package liwei.example.com.allpeoplelive.pager;

import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.library.baseactivity.BasePager;

import java.util.List;

import liwei.example.com.allpeoplelive.R;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/30
 */

public class Hot extends BasePager {
    public Hot(Activity activity) {
        super(activity);
    }

    @Override
    public View initViews() {
        View inflate = View.inflate(basePagerActivity, R.layout.hotpager, null);
      EditText editText = (EditText) inflate.findViewById(R.id.textinputet);
       TextInputLayout layout = (TextInputLayout) inflate.findViewById(R.id.textinputlay);
        layout.setHint("哈哈");

        return inflate;
    }

    @Override
    public void initDatas(List list) {

    }

}
