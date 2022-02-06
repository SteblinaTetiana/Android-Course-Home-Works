package com.triare.p131todolistapp.ui.categories

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.triare.p131todolist.R

public class CategoriesFragmentDirections private constructor() {
  public companion object {
    public fun actionCategoriesFragmentToTasksFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_categoriesFragment_to_tasksFragment)
  }
}
