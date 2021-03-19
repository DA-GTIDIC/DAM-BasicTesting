package cat.udl.tidic.amd.dam_basictesting;

import androidx.fragment.app.Fragment;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class SimpleFragmentTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);
    public Fragment fragment;

    private LoginActivity mActivity;


    @Before
    public void setUp() throws IOException {
        mActivity = mActivityRule.getActivity();
        fragment = new SimpleFragment();
        mActivity.getSupportFragmentManager()
                .beginTransaction().add(R.id.frameLayout, fragment).commit();
    }

    @Test
    public void FragmentElements(){
        onView(ViewMatchers.withId(R.id.firstButton))
                .check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.fragText))
                .check(matches(isDisplayed()))
                .check(matches(withText("This is First Fragment")));
    }

    @Test
    public void showToastOnClickButton(){
        onView(ViewMatchers.withId(R.id.firstButton))
                .perform(ViewActions.click());
        onView(withText("First Fragment")).
                inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }
}