package com.example.minipro;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {
DatabaseHelper mydb;
EditText word,meaning;
TextView tv;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
mydb = new DatabaseHelper(this);
word = (EditText)findViewById(R.id.editText);
meaning = (EditText)findViewById(R.id.editText2);
tv=(TextView)findViewById(R.id.textView);
tv.setText("YOUR DICTIONARY");
//on button click

Button b1 = (Button) findViewById(R.id.button1);
b1.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
boolean isInsertdata = mydb.insert(word.getText().toString(),
meaning.getText().toString());
if(isInsertdata = true){
Toast.makeText(getApplicationContext(), "Data inserted.",Toast.LENGTH_LONG).show();
}
else
Toast.makeText(getApplicationContext(), "Data not inserted.",Toast.LENGTH_LONG).show();
}
});
Button b3 = (Button) findViewById(R.id.button3);
b3.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
boolean isUpdatedata = mydb.update(word.getText().toString(),
meaning.getText().toString());
if(isUpdatedata = true){
Toast.makeText(getApplicationContext(), "Data Updated.",
Toast.LENGTH_LONG).show();
}
else
Toast.makeText(getApplicationContext(), "Data not Updated.",
Toast.LENGTH_LONG).show();
}
});
Button b2 = (Button) findViewById(R.id.button2);
b2.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
boolean isDelete = mydb.delete(word.getText().toString());
if(isDelete ==true){
Toast.makeText(getApplicationContext(), "Data Deleted.",
Toast.LENGTH_LONG).show();
}
else
Toast.makeText(getApplicationContext(), "Data not Deleted.",
Toast.LENGTH_LONG).show();
}
});
Button b4 = (Button) findViewById(R.id.button4);
b4.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
Intent intent=new Intent(MainActivity.this,Searchdata.class);
startActivity(intent);
}
});
}

public void showmsg(String title, String message){
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setCancelable(true);
builder.setTitle(title);
builder.setMessage(message);
builder.show();
}
}
