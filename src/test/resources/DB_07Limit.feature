Feature: Select and Limit
  Background:
    * The database connection is created.
    @query07
  Scenario: Check whether the phone data contains 5 according to the first 3 address information in the customer_addresses table
    * Query07 is prepared and executed.
    * ResultSet07 is processed.
    * The database connection is closed.