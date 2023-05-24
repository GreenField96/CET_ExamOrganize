package com.example.exam2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class answerPaperMovementModel{
    private ExceptionLogger log = ExceptionLogger.getInstance();
    private ArrayList<answerPaperMovementTable> papers;
    answerPaperMovementModel(){
        papers = new ArrayList<>();
    }
    public void store(){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            String query = "INSERT INTO answer_paper_movement (`committe_id` , `recent_id` , `date` , `number_papers_received` , `group`) VALUES ( ? , ? , ? , ? , ? ) ";
            statement = connection.prepareStatement(query);

            for (answerPaperMovementTable paper : papers) {
                statement.setInt(1, paper.getCommitteIdCol());
                statement.setInt(2, paper.getRecentIdCol());
                statement.setString(3, paper.getDateCol());
                statement.setString(4, paper.getNumberPaperRecivedCol());
                statement.setString(5, paper.getGroupCol());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException exception) {
            log.logException(exception);
        }
        papers.clear();
    }
    public void insert(answerPaperMovementTable paper){
        papers.add(paper);
    }
}
