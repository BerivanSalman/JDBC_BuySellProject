Feature: Insert into
  Background:
    * The database connection is created.
    @query02
  Scenario: Add a data containing the values (id,name,state_id,status,created_at) to the cities table.
  Verify that the data has been added to the cities table.
    * Query02 is prepared and executed.
    * PreparedResultSet02 is processed.
    * The database connection is closed.


