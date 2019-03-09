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


## Issues Encountered
* I had a hard time getting my new appetizers tab on the toolbar. I eventually figured out I
needed to change NUM_TABS to 5. I assumed NUM_TABS is passed up to the super class at some point to
tell it how many columns to render. I confirmed this in the HFAD book where it says that the number
is indeed passed up, via the getCount method (page 491).