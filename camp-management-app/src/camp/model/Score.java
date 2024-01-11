package camp.model;

public class Score {
    private String scoreId;
    int score = 0;
    public Score(String seq,int score) {
        this.scoreId = seq;
        this.score = score;
    }
  /// 안써도됨
    public void addscore(int score){
        this.score = score;
    }
    public String getScoreId() {
        return scoreId;
    }

    public int getScore(){return score;}
}
