package br.com.brsantiago.view.main

import br.com.brsantiago.domain.Issue

interface IssueListener {
    fun onIssueSelected(issue: Issue)
}