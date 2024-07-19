Feature: Insert and Delete
  Background:
    * The database connection is created.
    @query05
  Scenario:  Add a data containing (id,name,email,query_type,message) information in the contacts table.
  Delete the added data by entering the email information in the contacts table. Verify that it has been deleted.
    * Insert values to the contacts table
    * Delete the added data by entering the email information in the contacts table.
    * ResultSet is processed
    * The database connection is closed.