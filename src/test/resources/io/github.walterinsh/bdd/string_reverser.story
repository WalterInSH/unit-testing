Meta:
@author WalterInSH

Narrative:
I want to design a string reverser with a special feature.
It's able to return the uppercase result.
So it saves my time.

Scenario: need uppercase
Given create a reverser need uppercase true
When reverse abc
Then I should get CBA

Scenario: do not need uppercase
Given create a reverser need uppercase false
When reverse abc
Then I should get cba