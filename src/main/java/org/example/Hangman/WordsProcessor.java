package org.example.Hangman;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

@Data
@Slf4j
public class WordsProcessor {

    private long id;
    private String wordToGuess;
    private char[] wordToArray;

    HibernateFactory hibernateUtils = new HibernateFactory();
    SessionFactory sessionFactory = hibernateUtils.getSessionFactory();

    public String generateWord() {
        return readWord(3L);
    }

    public char[] makeCharArray(String word) {
        return word.toCharArray();
    }

    public boolean check(char[] array, char c) {
        boolean checkValue = false;
        for (char letter : array) {
            if (letter == c) {
                checkValue = true;
                break;
            }
        }
        return checkValue;
    }

    public String hash(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append("#");
        }
        return sb.toString();
    }

    public String partialUnhash(char[] array, char c, String hassedWord) {
        int counter = 0;
        char[] array2 = hassedWord.toCharArray();
        for (char letter : array) {
            if (letter == c) {
                array2[counter] = c;
            }
                counter++;
        }
        StringBuilder sb = new StringBuilder();
        for (char d : array2) {
            sb.append(d);
        }
        return sb.toString();
    }

    public void setNewWord(){
        this.wordToGuess = generateWord();
    }

    public void setNewArray(){
        this.wordToArray = makeCharArray(wordToGuess);
    }

    String readWord(long id) {
        StringBuilder sb = new StringBuilder();
        try (Session session = sessionFactory.openSession()) {
            Words words = session.get(Words.class,id);
            sb.append(words.getWord());

        }

        return sb.toString();
    }

    void addWord(String haslo) {
        try (Session session = sessionFactory.openSession()) {
            Words words = new Words();
            words.setWord(haslo);
            Serializable id = session.save(words);
            log.info("Saved word {}",id);
        }
    }

    void updateWord(Long id, String haslo) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Words words = session.get(Words.class, id);
            words.setWord(haslo);
            session.saveOrUpdate(words);
            log.info("Updated {}",words);
            transaction.commit();
        }
    }

    void deleteWord(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Words words = session.get(Words.class, id);
            session.delete(words);
            transaction.commit();
        }
    }
}
