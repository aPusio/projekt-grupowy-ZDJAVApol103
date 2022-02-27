package org.example.Hangman;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class WordsProcessorTest {
    private WordsProcessor processor = new WordsProcessor();

    @Mock
    private HibernateUtils hibernateUtils;

    @Mock
    private SessionFactory sessionFactory;

    @Test
    public void test(){
        //givne
        //processor.setHibernateUtils(hibernateUtils);

        //when
        //Mockito.when(hibernateUtils.getSessionFactory()).thenReturn(sessionFactory);
        //processor.addWord("HASLO!");

        //then
    }

}