Feature: DELETE
  Background:
    * The database connection is created.

  Scenario: Delete the data containing the values (id,name,state_id,status,created_at) in the cities table.
  Verify that it has been deleted.
    * Query03 is prepared and executed.
    * PreparedResultSet03 is processed.
    * The database connection is closed.

