package com.company.command;

public interface Command {

    boolean prepare();
    void commit();
    void rollback();
}
