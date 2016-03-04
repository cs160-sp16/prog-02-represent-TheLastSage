package rkolady.knowhow;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle data = getIntent().getExtras();
        Congress.Rep rep = (Congress.Rep) data.getParcelable("rep");

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_detail, null);

        ScrollView sv = (ScrollView) v.findViewById(R.id.scrollView2);

        TextView tv  = (TextView) findViewById(R.id.textView);
        tv.setText(rep.getName());

        TextView tv2  = (TextView) findViewById(R.id.textView2);
        tv2.setText(rep.getMail());

        TextView tv3  = (TextView) findViewById(R.id.textView3);
        tv3.setText(rep.getSite());

        ImageView pic = (ImageView) findViewById(R.id.imageView7);
        pic.setImageResource(getResources().getIdentifier("rkolady.knowhow:drawable/" + rep.getImgPath(), null, null));

//        ListView lv = (ListView) findViewById(R.id.listView);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                rep.getComm());
//
//        int height = 0;
//        ViewGroup vg = lv;
//        for (int i = 0; i < arrayAdapter.getCount(); i++) {
//            View listItem = arrayAdapter.getView(i, null, vg);
//            listItem.measure(0, 0);
//            height += listItem.getMeasuredHeight();
//        }
//
//        ViewGroup.LayoutParams params = lv.getLayoutParams();
//        params.height = height + (lv.getDividerHeight() * (arrayAdapter.getCount() - 1));
//        lv.setLayoutParams(params);
//        lv.setAdapter(arrayAdapter);
//
//        ListView lv2 = (ListView) findViewById(R.id.listView2);
//        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                rep.getBills());
//
//        int height2 = 0;
//        ViewGroup vg2 = lv2;
//        for (int i = 0; i < arrayAdapter2.getCount(); i++) {
//            View listItem = arrayAdapter2.getView(i, null, vg2);
//            listItem.measure(0, 0);
//            height += listItem.getMeasuredHeight();
//        }
//
//        params = lv2.getLayoutParams();
//        params.height = height2 + (lv2.getDividerHeight() * (arrayAdapter2.getCount() - 1));
//        lv2.setLayoutParams(params);
//        lv2.setAdapter(arrayAdapter2);

        TextView comms = (TextView) findViewById(R.id.textView4);
        StringBuilder out = new StringBuilder();
        for (String comm: rep.getComm()) {
            out.append(comm);
            out.append("\n");
        }

        Log.d("comm", out.toString());
        comms.setText(out.toString());

        TextView bills = (TextView) findViewById(R.id.textView5);
        StringBuilder out2 = new StringBuilder();
        for (String bill: rep.getBills()) {
            out2.append(bill);
            out2.append("\n");
        }

        bills.setText(out2.toString());


    }
}