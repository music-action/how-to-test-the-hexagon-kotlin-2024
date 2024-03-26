# origin: seed-TDD-Kotlin-2023
a seed to strat a TDD project in Kotlin with latest version of language + Kotest + Mockk
updated for kotlin_version = '1.9.22' +

# branches

in the branches, you can see many exercisms that we started to code based on that seed.

for now:
double-entry accounting

# Summary of the Domain : double-entry accounting

taken from https://abailly.github.io/posts/dependently-typed-accounting.html


## Basic Concepts
Here is an excerpt from Wikipedia page on double-entry bookkeeping:

In the double-entry accounting system, at least two accounting entries are required to record each financial transaction. These entries may occur in asset, liability, equity, expense, or revenue accounts. Recording of a debit amount to one or more accounts and an equal credit amount to one or more accounts results in total debits being equal to total credits for all accounts in the general ledger. If the accounting entries are recorded without error, the aggregate balance of all accounts having Debit balances will be equal to the aggregate balance of all accounts having Credit balances. Accounting entries that debit and credit related accounts typically include the same date and identifying code in both accounts, so that in case of error, each debit and credit can be traced back to a journal and transaction source document, thus preserving an audit trail. The accounting entries are recorded in the “Books of Accounts”. Regardless of which accounts and how many are impacted by a given transaction, the fundamental accounting equation of assets equal liabilities plus capital will hold.

From this description we get some basic information about the “domain” that we’ll want to implement:

A transaction comprises at least 2 entries
An entry records a debit or credit amount in an account
An account can fall into 5 different categories: asset, liability, equity, expense, or revenue
The aggregate debit and credit balance of all accounts should be equal
A book of accounts should preserve a fundamental equation that ensures asset = liability + equity1
From these elements, we can start to code and first of all define the types we’ll need. The whole point of this series of post is to apply DDD principles to Type-Driven Development which means we want our domain concepts to be reflected directly into the core domain of our code. So we end up needing the following types:

An Entry which contains an Account and some amount (more on this later) with a Direction, Debit or Credit,
A Transaction has a date, a String label and a list of Entry which must be Balanced,
A BookOfAccounts is a list of Transactions such that the fundamental equation holds at all time.

## resources 

https://app.excalidraw.com/l/A71COCUHrgv/4x4KHeQgjUP