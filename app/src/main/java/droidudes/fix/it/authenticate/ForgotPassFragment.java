package droidudes.fix.it.authenticate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import droidudes.fix.it.R;
import droidudes.fix.it.parentbase.BaseFragment;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public class ForgotPassFragment extends BaseFragment implements View.OnClickListener {

    private EditText etPassword;
    private Button btnResetPassword;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etPassword = (EditText) view.findViewById(R.id.et_email);
        btnResetPassword = (Button) view.findViewById(R.id.btn_reset_pass);

        btnResetPassword.setOnClickListener(this);
    }

    @Override
    public int setResourceLayoutID() {
        return R.layout.forgot_pass_fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reset_pass:
                Toast.makeText(getActivity(), "Password Send", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
