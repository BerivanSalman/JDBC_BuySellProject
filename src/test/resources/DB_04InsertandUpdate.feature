Feature: INSERT and UPDATE
  Background:
    * The database connection is created.
@query04
  Scenario:  Add a data containing the values (id,name,query_type,message)to the contacts table
    and later Update the message content
    * Insert values to the contacts table
    * Update the message content
    * ResultSet is processed
    * The database connection is closed.
