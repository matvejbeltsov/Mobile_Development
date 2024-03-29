package ru.mirea.beltsovmd.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Create a new instance of ProgressDialog and return it
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return progressDialog;
    }
}
