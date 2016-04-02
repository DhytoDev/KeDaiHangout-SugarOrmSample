package org.kedai.sugar_orm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.kedai.sugar_orm.models.Note;
import org.kedai.sugar_orm.utils.Util;

public class NoteFormActivity extends AppCompatActivity {

    private EditText edtTitle, edtTask ;
    private Button btnSubmit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_form);

        edtTitle = (EditText) findViewById(R.id.edt_title);
        edtTask = (EditText) findViewById(R.id.edt_task_description);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString().trim();
                String task = edtTask.getText().toString().trim();

                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(task)) {
                    Toast.makeText(NoteFormActivity.this, "EditText gak boleh kosong !!", Toast.LENGTH_SHORT).show();
                } else {
                    Note note = new Note(Util.getNewId(), title, task, Util.getCurrentDate());
                    note.save();

                    Intent i = new Intent(NoteFormActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
