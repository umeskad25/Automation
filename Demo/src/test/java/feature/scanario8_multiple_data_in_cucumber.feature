Feature: scanario8
Scenario Outline: parameterization
	Given Latest Foreign Exchange rates API given
	When posted with multiple <date> information
	Then validate Response

	Examples: 
      | date  |
      | "2015-01-12" |
      |"2016-01-12" | 