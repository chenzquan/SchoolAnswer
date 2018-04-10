package com.example.schoolanswer.Question;

import android.content.Context;

import com.example.schoolanswer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 权 on 2018/3/26.
 */

public class QuestionLab {

    private static QuestionLab sQuestionLab;

    private List<QuestionItem> mQuestionItem;



    public static QuestionLab get(Context context){
        if(sQuestionLab==null){
            sQuestionLab = new QuestionLab(context);
        }
        return sQuestionLab;
    }


    private QuestionLab(Context context){
        mQuestionItem = new ArrayList<>();
        QuestionItem questionItem = new QuestionItem(R.drawable.i1,"乐观的马克","你对即将上大学的新生有什么建议？","4");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i2,"去掉浮华虚夸","男生会因为心软,而和另一个女生在一起吗？","8");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i3,"姑娘微笑有酒窝","双非一本院校的学生,怎么才能进入名校读研究生？还是说，基本无缘？","22");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i4,"风吹裙尾","你认为有哪些越早明白越好的人生道理？","23");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i5,"我是太平公主","你们学生时期的\"女混混\"现在怎么样了?","42");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i6,"烟花巷陌","你想对那些校园混混说些什么？","42");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i7,"逗比就要逗比范er","那些在大学懒散的同学,最后都怎么样了?","74");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i8,"潮湿的黄瓜","愚笨高中生该如何自救？","123");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i9,"据说微胖的女孩光芒万丈","在大学里没有谈过恋爱,在毕业后是不是会有遗憾感和后悔感？","1");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i10,"冰恋绝舞","做科研,做科学家,最让您产生挫折感的是什么?","3");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i11,"钻石妹","学校问题去哪反映？","4");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i12,"宁做女王i","名校出身的你，毕业后一定会从事本专业的工作吗？","7");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i13,"凉宸","高考为了分数拼命有意义吗","9");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i14,"不会挽留i","高中生考试心态如何调整？","10");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i15,"拼命十三妹i","高中生该不该谈恋爱？","12");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i16,"难割舍","如何提高学习的执行力度？","13");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i17,"不知好歹","中国中小学教师的待遇是不是非常低?","14");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i18,"哥是师爷","南京外国语学校是一所怎样的学校？","14");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i19,"总有刁民想害朕","高三生如何在最后的90天里提高效率?","25");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i20,"此侽甚暖","高考最后60天了，怎样达到自己的极限？","10");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i21,"人潮拥挤你别迷路","如何提高学习的执行力度？","74");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i22,"深爱是罪","中国大学老师的收入是普遍偏低吗？如果是，为什么？","10");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i23,"鱼越此时海","高中学习什么应试方法是好的","20");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i24,"北朝寻歌","如果知乎承包中小学，会培养出怎么样的学生？","32");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i25,"万人迷","中国学校为什么要强制对学生划分等级？","21");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i26,"南岛托梦","学霸们是如何高效率地学习、工作、生活的？","23");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i27,"消失的回忆","申请文书与学术论文到底难在哪里？","25");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i28,"怪人友er","学问题儿童的原因主要来自哪里？","46");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i29,"仲夏之夜","为什么很多大学生毕业后都说大学所学知识无用？","47");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i30,"栀子花","老师究竟可以有多坏","54");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i31,"难再相拥","有哪些读书学不来，却很重要的素质？","12");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i32,"伤心童话","为什么部分中国学生不喜欢在课堂上主动提问？","32");
        mQuestionItem.add(questionItem);


        questionItem = new QuestionItem(R.drawable.i2,"去掉浮华虚夸","男生会因为心软,而和另一个女生在一起吗？","8");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i3,"姑娘微笑有酒窝","双非一本院校的学生,怎么才能进入名校读研究生？还是说，基本无缘？","22");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i4,"风吹裙尾","你认为有哪些越早明白越好的人生道理？","23");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i5,"我是太平公主","你们学生时期的\"女混混\"现在怎么样了?","42");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i6,"烟花巷陌","你想对那些校园混混说些什么？","42");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i7,"逗比就要逗比范er","那些在大学懒散的同学,最后都怎么样了?","74");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i8,"潮湿的黄瓜","愚笨高中生该如何自救？","123");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i9,"据说微胖的女孩光芒万丈","在大学里没有谈过恋爱,在毕业后是不是会有遗憾感和后悔感？","1");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i10,"冰恋绝舞","做科研,做科学家,最让您产生挫折感的是什么?","3");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i11,"钻石妹","学校问题去哪反映？","4");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i12,"宁做女王i","名校出身的你，毕业后一定会从事本专业的工作吗？","7");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i13,"凉宸","高考为了分数拼命有意义吗","9");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i14,"不会挽留i","高中生考试心态如何调整？","10");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i15,"拼命十三妹i","高中生该不该谈恋爱？","12");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i16,"难割舍","如何提高学习的执行力度？","13");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i17,"不知好歹","中国中小学教师的待遇是不是非常低?","14");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i18,"哥是师爷","南京外国语学校是一所怎样的学校？","14");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i19,"总有刁民想害朕","高三生如何在最后的90天里提高效率?","25");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i20,"此侽甚暖","高考最后60天了，怎样达到自己的极限？","10");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i21,"人潮拥挤你别迷路","如何提高学习的执行力度？","74");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i22,"深爱是罪","中国大学老师的收入是普遍偏低吗？如果是，为什么？","10");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i23,"鱼越此时海","高中学习什么应试方法是好的","20");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i24,"北朝寻歌","如果知乎承包中小学，会培养出怎么样的学生？","32");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i25,"万人迷","中国学校为什么要强制对学生划分等级？","21");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i26,"南岛托梦","学霸们是如何高效率地学习、工作、生活的？","23");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i27,"消失的回忆","申请文书与学术论文到底难在哪里？","25");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i28,"怪人友er","学问题儿童的原因主要来自哪里？","46");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i29,"仲夏之夜","为什么很多大学生毕业后都说大学所学知识无用？","47");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i30,"栀子花","老师究竟可以有多坏","54");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i31,"难再相拥","有哪些读书学不来，却很重要的素质？","12");
        mQuestionItem.add(questionItem);
        questionItem = new QuestionItem(R.drawable.i32,"伤心童话","为什么部分中国学生不喜欢在课堂上主动提问？","32");
        mQuestionItem.add(questionItem);



    }

    public List<QuestionItem> getmQuestionItem(){
        return mQuestionItem;
    }

    



}
