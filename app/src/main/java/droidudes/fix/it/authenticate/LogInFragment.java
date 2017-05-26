package droidudes.fix.it.authenticate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import droidudes.fix.it.MainDrawerActivity;
import droidudes.fix.it.R;
import droidudes.fix.it.common.Constants;
import droidudes.fix.it.parentbase.BaseFragment;
import droidudes.fix.it.sharedprefs.SharedPrefs;

/**
 * Created by Zare Ahmed on 10/29/2016.
 */
public class LogInFragment extends BaseFragment implements View.OnClickListener
{
    private Context mContext;
    private EditText etEmail,etPassword;
    private TextView tvForgotPassword ,tvSignUp;
    private Button btnLogin;
    private AuthenticateActivity activityInstance;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity();
        activityInstance = (AuthenticateActivity) getActivity();

        etEmail = (EditText) view.findViewById(R.id.et_email);
        etPassword = (EditText) view.findViewById(R.id.et_password);

        tvForgotPassword = (TextView) view.findViewById(R.id.tv_forgot_password);
        tvSignUp = (TextView) view.findViewById(R.id.tv_sign_up);
        btnLogin = (Button) view.findViewById(R.id.btn_login);

        etEmail.setText(SharedPrefs.read(Constants.LAST_EMAIL_KEY, ""));

        tvSignUp.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_sign_up:
                if(activityInstance != null)
                    activityInstance.replaceAFragment(new SignUpFragment());
                ///Activities.replaceAFragment(getActivity(),new SignUpFragment());
                break;
            case R.id.tv_forgot_password:
                if(activityInstance != null)
                    activityInstance.replaceAFragment(new ForgotPassFragment());
                ///Activities.replaceAFragment(getActivity(),new ForgotPassFragment());
            break;
            case R.id.btn_login:
                if(etEmail.getText().toString().trim().equals("email") && etPassword.getText().toString().equals("password"))
                {
                    SharedPrefs.save(Constants.LAST_EMAIL_KEY , etEmail.getText().toString());
                    startActivity(new Intent(getActivity() , MainDrawerActivity.class));
                    getActivity().finish();
                }
            break;
        }
    }

    @Override
    public int setResourceLayoutID() {
        return R.layout.activity_login;
    }
}
