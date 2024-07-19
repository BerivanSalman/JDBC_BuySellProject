Feature: Group by
  Background:
    * The database connection is created.
    @query06
  Scenario: Group the coupon_products table by coupon_id and find how many products there are for each coupon.
    * Query06 is prepared and executed.
    * ResultSet06 is processed.
    * The database connection is closed.
