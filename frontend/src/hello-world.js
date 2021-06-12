import {PolymerElement,html} from '@polymer/polymer/polymer-element.js';
import '@polymer/paper-input/paper-input.js';


class HelloWorld extends PolymerElement {

    static get template() {
        return html`
            <div>
              <h1>header</h1>
            </div>
             <div id=content>
             some text
              </div>
            `;
    }

    static get is() {
          return 'hello-world';
    }
}

customElements.define(HelloWorld.is, HelloWorld);

