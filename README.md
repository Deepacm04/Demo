**Scenarios**
Scenario 1: Verify Count for Symbols Containing "XRP" and FirstId > 0
In this scenario, the API response is validated to ensure that:

For any symbol that contains "XRP," the firstId is above zero.
The count should be above zero for such symbols.
Scenario 2: Verify Symbol Name as a Concatenation of baseAsset and quoteAsset
This scenario verifies:

The symbol field in the exchange API response should be a concatenation of baseAsset and quoteAsset.
