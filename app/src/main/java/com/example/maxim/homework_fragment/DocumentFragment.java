package com.example.maxim.homework_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DocumentFragment extends Fragment {
    private static String DOCUMENT_NUMBER = "DOCUMENT_NUMBER";

    private int num;

    public static DocumentFragment create(int num) {
        Bundle bundle = new Bundle();
        bundle.putInt(DOCUMENT_NUMBER, num);

        DocumentFragment documentFragment = new DocumentFragment();
        documentFragment.setArguments(bundle);
        documentFragment.setRetainInstance(true);

        return documentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        num = getArguments().getInt(DOCUMENT_NUMBER);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.document_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView textView = view.findViewById(R.id.document_num_text_view);
        textView.setText("Документ №" + num);

        super.onViewCreated(view, savedInstanceState);
    }
}
