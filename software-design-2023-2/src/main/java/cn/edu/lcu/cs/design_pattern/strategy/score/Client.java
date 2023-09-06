package cn.edu.lcu.cs.design_pattern.strategy.score;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Score> scores = new ScoreDB().findAll();


        // 期末成绩分析，不使用环境对象
        ScoreAnalyseStrategy analyseStrategy = new TermScoreAnalyseStrategy(scores);
        analyseStrategy.analyse();
        System.out.println(analyseStrategy);

        // 实验成绩分析，不使用环境对象
        analyseStrategy = new ExperimentScoreAnalyseStrategy(scores);
        analyseStrategy.analyse();
        System.out.println(analyseStrategy);

        // 期末成绩分析，使用环境对象
        ScoreAnalyseContext context = new ScoreAnalyseContext(scores);
        context.setAnalyseStrategy(new ExperimentScoreAnalyseStrategy());
        context.analyse();
        System.out.println(context.getMax());
    }
}
