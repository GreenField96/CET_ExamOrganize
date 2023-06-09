package com.example.exam2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class answerPaperMovementModel{
    private ExceptionLogger log = ExceptionLogger.getInstance();
    private ArrayList<answerPaperMovementTable> papers = new ArrayList<>();

    public void store(){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = db.getDBConnection();
            String query = "INSERT INTO answer_paper_movement (`committe_id`,`he_had_id`,`he_have_id`,`date`,`number_papers_received`,`specification`,`group`) VALUES ( ? , ? ,  ? , ? , ? , ? , ? ) ";
            statement = connection.prepareStatement(query);

            for (answerPaperMovementTable paper : papers) {
                statement.setInt(1, paper.getCommitteIdCol());
                statement.setInt(2, paper.getHeHadCol());
                statement.setInt(3, paper.getHeHaveCol());
                statement.setString(4, paper.getDateCol());
                statement.setString(5, paper.getNumberPaperRecivedCol());
                statement.setString(6, paper.getSpecificCol());
                statement.setString(7, paper.getGroupCol());
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
