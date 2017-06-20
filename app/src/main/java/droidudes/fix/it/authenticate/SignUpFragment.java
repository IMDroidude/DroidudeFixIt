package droidudes.fix.it.authenticate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import droidudes.fix.it.MainDrawerActivity;
import droidudes.fix.it.R;
import droidudes.fix.it.parentbase.BaseFragment;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public class SignUpFragment extends BaseFragment {

    private TextInputEditText emailTie,passwordTie,
            confirmPasswordTie,userNameTie;
    private Button signUpBtn;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailTie = (TextInputEditText) view.findViewById(R.id.tie_email);
        passwordTie = (TextInputEditText) view.findViewById(R.id.tie_password);
        confirmPasswordTie = (TextInputEditText) view.findViewById(R.id.tie_confirm_password);
        userNameTie = (TextInputEditText) view.findViewById(R.id.tie_username);

        signUpBtn = (Button) view.findViewById(R.id.btn_sign_up);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call sign UP service here...
                Intent intent = new Intent(getActivity(), MainDrawerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int setResourceLayoutID() {
        return R.layout.sign_up_fragment;
    }

    @Override
    public int setMenuID() {
        return 0;
    }
}
