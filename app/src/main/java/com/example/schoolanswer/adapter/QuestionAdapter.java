package com.example.schoolanswer.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ProviderInfo;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schoolanswer.MainActivity;
import com.example.schoolanswer.Question.QuestionItem;
import com.example.schoolanswer.R;
import com.example.schoolanswer.activity.Main2answers;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by 权 on 2018/3/26.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>{

    private Context context;
    private List<QuestionItem> mQuestionItem;



    public QuestionAdapter(List<QuestionItem> mQuestionItem){
        this.mQuestionItem = mQuestionItem;
    }





    public class QuestionViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private CircleImageView circleImageView;
        private TextView UserName;
        private TextView Question;
        private TextView pinglun;

        public QuestionViewHolder(View view){
            super(view);

            cardView = (CardView) view;
            circleImageView = (CircleImageView) view.findViewById(R.id.iv_avatar);
            UserName = (TextView) view.findViewById(R.id.UserName);

            Question = (TextView) view.findViewById(R.id.tv_item_title);
            pinglun = (TextView) view.findViewById(R.id.tv_item_guanzhu);
        }

    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(context==null){
            context = parent.getContext();
        }

        View view = LayoutInflater.from(context).inflate(R.layout.main_item,parent,false);
        final QuestionViewHolder questionViewHolder = new QuestionViewHolder(view);

         questionViewHolder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = questionViewHolder.getAdapterPosition();
                QuestionItem questionItem = mQuestionItem.get(position);
                Intent intent = new Intent(context, Main2answers.class);
                intent.putExtra(Main2answers.UserName,questionItem.getUserName());
                intent.putExtra(Main2answers.Question,questionItem.getQuestion());
                intent.putExtra(Main2answers.ImageId,questionItem.getImageId());
                context.startActivity(intent);
            }
        });

        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        QuestionItem questionItem = mQuestionItem.get(position);
        holder.circleImageView.setImageResource(questionItem.getImageId());
        holder.UserName.setText(questionItem.getUserName());
        holder.Question.setText(questionItem.getQuestion());
        holder.pinglun.setText(questionItem.getPinglun());

    }

    @Override
    public int getItemCount() {
        return mQuestionItem.size();
    }
}
