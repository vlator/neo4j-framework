/*
 * Copyright (c) 2015 GraphAware
 *
 * This file is part of GraphAware.
 *
 * GraphAware is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.graphaware.writer;

import org.neo4j.graphdb.GraphDatabaseService;

import static java.util.concurrent.Executors.callable;

/**
 * Abstract base class for {@link DatabaseWriter} implementations.
 */
public abstract class BaseDatabaseWriter implements DatabaseWriter {

    protected final GraphDatabaseService database;

    /**
     * Create a new database writer.
     *
     * @param database to write to.
     */
    protected BaseDatabaseWriter(GraphDatabaseService database) {
        this.database = database;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        //no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        //no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(Runnable task) {
        write(task, "UNKNOWN");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(Runnable task, String id) {
        write(callable(task), id, 0);
    }
}
