# Exercise for Mobile Application Development

## To Do
- [x] Remove magic number from MainActivity.SectionsPagerAdapter.
- [x] Test and commit.
- [x] Refactor PastaFragment, PizzaFragment, and StoresFragment by moving common code into a new abstract superclass.
- [x] Test and commit.
- [x] Add another screen (e.g., AppetizerFragment).
- [x] Test and commit.

Challenge:  
- [x] Improve MainActivity.SectionsPagerAdapter (possibly moving code elsewhere).
- [x] Add a string-array named tabs to strings.xml that lists the tab titles in order.
- [x] Rewrite getPageTitle() to eliminate magic numbers and use tabs to determine order.

Double challenge:  
- [x] Ditto for getItem()

- [x] Push commits to Github.
- [x] Submit pull request.

## Issues Encountered
* I had a hard time getting my new appetizers tab on the toolbar; the issue was that I did not know I
needed to change NUM_TABS to 5. I discovered this in HFAD (page 491) where it says that the number
is passed up to the super class via the getCount method so the toolbar knows how many buttons to create.

## Time Taken
~2 hours.