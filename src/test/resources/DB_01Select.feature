Feature: Select
  Background:
    * The database connection is created.
    @query01
  Scenario: Verify the name value of a categorie with 'slug = fashion' in the Categories table.
    * Query01 is prepared and executed.
    * ResultSet01 is processed.
    * The database connection is closed.
