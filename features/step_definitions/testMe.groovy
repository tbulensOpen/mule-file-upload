
import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

Before() {

}

After() {

}

class CustomWorld {

}

Given(~"a test file") { ->
    pending
}
When(~"run test") { ->
    pending
}

Then(~"verify it is successful") { ->
    assert true
}