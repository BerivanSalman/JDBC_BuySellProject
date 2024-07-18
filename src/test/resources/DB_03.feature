Feature: DELETE
  Background:
    * The database connection is created.
@query03
  Scenario: Delete the data containing the values (id=?,name=?) in the cities table.
  Verify that it has been deleted.
    * Query03 is prepared and executed.
    * PreparedResultSet03 is processed.
    * The database connection is closed.

