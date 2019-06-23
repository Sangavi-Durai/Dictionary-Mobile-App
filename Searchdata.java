package com.example.minipro;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.Toast;
public class Searchdata extends Activity {
TextView tv,tv1;
EditText ed1;
DatabaseHelper mydb;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_searchdata);
tv=(TextView)findViewById(R.id.textView);
tv.setText("SEARCH DATA");
tv1=(TextView)findViewById(R.id.textView1);
ed1=(EditText)findViewById(R.id.editText);
mydb = new DatabaseHelper(this);
Button b1 = (Button) findViewById(R.id.button);
b1.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
String str1;
str1=ed1.getText().toString();
StringBuffer s2=new StringBuffer();
Cursor res = mydb.searchData(str1);
while(res.moveToNext()){
s2.append("WORD : "+res.getString(0)+"\n");
s2.append("MEANING : "+res.getString(1)+"\n");
}
Toast.makeText(getBaseContext(),s2.toString(),Toast.LENGTH_LONG).show();
}
});
Button b2 = (Button) findViewById(R.id.button1);
b2.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
Cursor res = mydb.getAllData();
StringBuffer buffer = new StringBuffer();
while(res.moveToNext()){
buffer.append("WORD : "+res.getString(0)+"\n");
buffer.append("MEANING : "+res.getString(1)+"\n");
}
Toast.makeText(getBaseContext(),buffer.toString(),Toast.LENGTH_LONG).show();
}
});
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.searchdata, menu);
return true;
}}
